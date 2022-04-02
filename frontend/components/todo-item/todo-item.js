import React from "react";

const TodoItem = ({ label, onMouseOverLabel, onMouseOutLabel }) => {
    return (
        <span className="todo-item">
            <button type="button"
                className="btn btn-outline-success btn-sm">
            </button>

            <button type="button"
                className="btn btn-outline-primary btn-sm">
            </button>

            <button type="button"
                className="btn btn-outline-danger btn-sm">
            </button>

            <span
                onMouseOver={ onMouseOverLabel }
                onMouseOut={ onMouseOutLabel }
                className="todo-item-label">
                {label}
            </span>
        </span>
    );
};
export default TodoItem;