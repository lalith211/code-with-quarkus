import React, { useState } from "react";
import { Form, InputGroup, Button, Table } from "react-bootstrap";

export default () => {
  const [data, setData] = useState({});
  const handleSubmit = (e) => {
    e.preventDefault();
    setData({ key1: "value1", key2: "value2" });
  };
  return (
      <div>
        <Form onSubmit={handleSubmit}>
          <InputGroup className="mb-3">
            <InputGroup.Text id="basic-addon3">Bill No:</InputGroup.Text>
            <Form.Control id="basic-url" aria-describedby="basic-addon3" />
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
