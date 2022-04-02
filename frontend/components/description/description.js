import React from "react";

export default class Description extends React.Component {
    findDescription(todoItems, selectedItemId) {
        let description = "Hover over the todo item to get a description";
        // find array index by description id and get description
        if (todoItems.length > 0 && typeof (selectedItemId) != 'undefined' && selectedItemId != null) {
            const idx = todoItems.findIndex((el) => el.id === selectedItemId);
            description = todoItems[idx].description;
        }
        if (todoItems.length === 0){
            description = "Have no any todo items";
        }
         return description;
    };

    render() {
        const { todoItems, selectedItemId } = this.props;
        const content = this.findDescription(todoItems, selectedItemId);
        return (
            <div className="description">
                <div className="description-text">Description</div>
                <div className="description-content">{content}</div>
            </div>
        );
    };


};

