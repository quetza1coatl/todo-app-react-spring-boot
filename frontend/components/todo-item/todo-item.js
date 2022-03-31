import React from "react";

const TodoItem = () => {
    return (
        <span className="todo-item">
            <button type="button"
                className="btn btn-outline-success btn-sm">
            </button>

            <button type="button"
                className="btn btn-outline-danger btn-sm">
            </button>

            <span
                className="todo-item-label">
                Hardcoded item
            </span>
        </span>
    );
};
export default TodoItem;