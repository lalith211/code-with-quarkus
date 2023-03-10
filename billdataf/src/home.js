import React, { useRef, useState } from "react";
import { Form, Button } from "react-bootstrap";

export default () => {
    const [message, setMessage] = useState("");
    const [fileInputKey, setFileInputKey] = useState(Date.now()); // add key to reset file input
    const ref = useRef();

    const handleSubmit = (e) => {
        e.preventDefault();
        if (ref.current.files[0]) {
            const formData = new FormData();
            formData.append("pdfFile", ref.current.files[0]);
            fetch("http://localhost:8080/pdf-to-text", {
                mode: 'no-cors',
                method: "POST",
                body: formData,
            })
                .then((response) => response.status === 200)
                .then((data) => {
                    setMessage("Successfully submitted");
                    console.log(data);
                    setFileInputKey(Date.now()); // reset file input
                })
                .catch((error) => {
                    setMessage("Failed to submit");
                    console.error(error);
                });
        } else {
            setMessage("Please select file before submitting");
        }
        console.log(ref.current.files[0]);
    };

    return (
        <div>
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formFile" className="mb-3">
                    <Form.Label>Please select file you want to Extract</Form.Label>
                    <Form.Control type="file" key={fileInputKey} ref={ref} />
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
            <p className="mt-3" style={{ display: message ? "block" : "none" }}>
                {message}
            </p>
        </div>
    );
};
