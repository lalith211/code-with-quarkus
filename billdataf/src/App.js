import 'bootstrap/dist/css/bootstrap.min.css';
import "./styles.css";
import React, { useState } from "react";
import { Tab, Tabs } from "react-bootstrap";
import Home from "./home";
import Details from "./details";

export default function App() {
  const [key, setKey] = useState("home");
  return (
      <div className="App">
        <h1 id="pdf">PDF Extractor</h1>

          <div id="yty" class="p-4">
        <Tabs activeKey={key} onSelect={(k) => setKey(k)} className="mb-3">
          <Tab  id="controlled-tabs" eventKey="home" title="Home">
            <Home />
          </Tab>
          <Tab eventKey="details" title="Details">
            <Details />
          </Tab>
        </Tabs>
      </div>
      </div>
  );
}
