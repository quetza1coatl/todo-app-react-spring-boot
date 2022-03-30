import React from "react";
import TodoItem from "../todo-item";

const TodoList = () => {
    return (
        <ul className="list-group todo-list">
            <li className="list-group-item">
                <TodoItem/>
            </li>
            <li className="list-group-item">
                <TodoItem/>
            </li>
        </ul>
    );
};
export default TodoList;