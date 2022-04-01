import React from "react";
import TodoItem from "../todo-item";

const TodoList = ({ data }) => {
    console.log(data);
    const elements = data.map((item) => {
        const { id, label } = item;

        return (
            <li key={id} className="list-group-item">
                <TodoItem label={label} />
            </li>
        );
    });

    return (
        <ul className="list-group todo-list">
            {elements}
        </ul>
    );
};
export default TodoList;