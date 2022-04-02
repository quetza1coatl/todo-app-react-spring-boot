import React from "react";
import TodoItem from "../todo-item";

const TodoList = ({ data, onMouseOverLabel, onMouseOutLabel }) => {

    const elements = data.map((item) => {
        const { id, label } = item;

        return (
            <li key={id} className="list-group-item">
                <TodoItem 
                label={label}
                onMouseOverLabel = {() => onMouseOverLabel(id)}
                onMouseOutLabel = {() => onMouseOutLabel()}/>
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