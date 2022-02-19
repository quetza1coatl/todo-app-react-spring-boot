import React, { Component } from "react";
import ReactDOM from "react-dom";
import Header from "../../../frontend/components/header";


export class App extends Component {
    render() {
        return (
            <div>
                <Header />
            </div>
    );
    }
}

export default App;

ReactDOM.render(<App />, document.querySelector("#app"));
