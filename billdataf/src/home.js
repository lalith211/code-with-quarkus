import React, { useRef, useState } from "react";
import { Form, Button } from "react-bootstrap";

export default () => {
    const [message, setMessage] = useState("");
    const ref = useRef();
    const handleSubmit = (e) => {
        e.preventDefault();
        if (ref.current.files[0]) {
            setMessage("Successfully submitted");
        } else {
            setMessage("Please select file before submitting");
        }
        console.log(ref.current.files[0]);
    };
    return (
        <div>
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formFile" className="mb-3">
                    <Form.Label>Please select file you want to store</Form.Label>
                    <Form.Control type="file" ref={ref} />
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
