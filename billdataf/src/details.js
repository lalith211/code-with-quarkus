import React, { useState } from "react";
import { Form, InputGroup, Button, Table } from "react-bootstrap";

export default () => {
  const [data, setData] = useState({});
  const [billNo, setBillNo] = useState("");
  const [message, setMessage] = useState("");
  const handleSubmit = (e) => {
    e.preventDefault();
    setData({ key1: "value1", key2: "value2" , key3: "value3" });
    fetch(`http://localhost:8080/get-bill-details/${billNo}`, {
                    mode: 'no-cors',
                    method: "GET",
                })
                    .then((response) => response.json())
                    .then((data) => {
                        setMessage("Successfully submitted");
                    })
                    .catch((error) => {
                        setMessage("Failed to submit");
                        console.error(error);
                    });
                    setData({ "Bill No": data.billNo, "Date": data.date, "Name": data.name, "Truk Number": data.trukNum });

  };
   const handleBillNoChange = (e) => {
                          setBillNo(e.target.value);
                        };
  return (
    <div>
      <Form onSubmit={handleSubmit}>
        <InputGroup className="mb-3">
          <InputGroup.Text id="basic-addon3">Bill No:</InputGroup.Text>
          <Form.Control
            id="basic-url"
            aria-describedby="basic-addon3"
            value={billNo}
            onChange={handleBillNoChange}
          />
          <Button variant="primary" type="submit">
            Search
          </Button>
        </InputGroup>
      </Form>
      <div style={{ display: Object.keys(data).length ? "block" : "none" }}>
        <Table striped bordered hover>
          <tbody>
            {Object.keys(data).map((record, index) => (
              <tr key={index}>
                <td>{record}</td>
                <td>{Object.values(data)[index]}</td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    </div>
  );
};
