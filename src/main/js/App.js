import React, { Component } from "react";
import ReactDOM from "react-dom";
import Header from "../../../frontend/components/header";
import TodoList from "../../../frontend/components/todo-list";


export class App extends Component {
    render() {
        return (
            <div>
                <Header />
                <TodoList />
            </div>
    );
    }
}

export default App;

ReactDOM.render(<App />, document.querySelector("#app"));
