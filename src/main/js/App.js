import React, { Component } from "react";
import ReactDOM from "react-dom";
import Description from "../../../frontend/components/description";
import Header from "../../../frontend/components/header";
import TodoList from "../../../frontend/components/todo-list";
import axios from "axios";


export default class App extends Component {
    state = {
        todoItems: [],
        selectedItemId: null
    };

    componentDidMount() {
        axios.get('/rest/items')
            .then(response => this.setState({ todoItems: response.data }));
    };

    onMouseOverLabel = (id) => {
        this.setState({ selectedItemId: id });
    };

    onMouseOutLabel = () => {
        this.setState({ selectedItemId: null });
     };

    render() {
        const { todoItems, selectedItemId } = this.state;
        return (
            <div>
                <Header />
                <TodoList
                    data={todoItems}
                    onMouseOverLabel={this.onMouseOverLabel}
                    onMouseOutLabel={this.onMouseOutLabel}
                />
                <Description
                    todoItems={todoItems}
                    selectedItemId={selectedItemId} />
            </div>
        );
    }
}

ReactDOM.render(<App />, document.querySelector("#app"));
