import 'bootstrap/dist/css/bootstrap.min.css';
import "./styles.css";
import React, { useState,useEffect } from "react";
import { Tab, Tabs } from "react-bootstrap";
import Home from "./home";
import Details from "./details";

export default function App() {

  const [key, setKey] = useState("home");

  useEffect(() => {
    document.body.classList.add("no-scroll");

    return () => {
      document.body.classList.remove("no-scroll");
    };
  }, []);
    return (

        <div className="App" >
            <img src='https://legal.thomsonreuters.com/content/dam/ewp-m/images/legal/en/artworked-images/tr1109452-hero-4.png.transform/rect-768/q90/image.png' height='100%' width='100%' align='center' position ='fixed' />
          <div className="Appim">
      <div className="AppBody">
          <div id="logo-container">

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
      </div>
        </div>
        </div>
  );
}
