import React from "react";

const TodoItem = () => {
    return (
        <span className="todo-item">
            <span
                className="todo-item-label">
                Hardcoded item
            </span>

            <button type="button"
                className="btn btn-outline-success btn-sm float-right">
            </button>

            <button type="button"
                className="btn btn-outline-danger btn-sm float-right">
            </button>
        </span>
    );
};
export default TodoItem;