import React, { Component } from "react";
import ReactDOM from "react-dom";
import Description from "../../../frontend/components/description";
import Header from "../../../frontend/components/header";
import TodoList from "../../../frontend/components/todo-list";
import axios from "axios";


export default class App extends Component {
    state = {
        todoItems: []
    };

    componentDidMount() {
        axios.get('/rest/items')
            .then(response => this.setState({ todoItems: response.data }));
    };

    render() {
        return (
            <div>
                <Header />
                <TodoList
                    data={this.state.todoItems} />
                <Description />
            </div>
        );
    }
}

ReactDOM.render(<App />, document.querySelector("#app"));
