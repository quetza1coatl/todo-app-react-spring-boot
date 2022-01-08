package com.quetzalcoatl.todoappreactspringboot;

import com.quetzalcoatl.todoappreactspringboot.model.TodoItem;
import com.quetzalcoatl.todoappreactspringboot.repository.TodoItemRepository;
import com.quetzalcoatl.todoappreactspringboot.util.TodoPriority;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class TodoItemCRUDTests {
    @Autowired
    TodoItemRepository repository;

    @Test
    public void testSaveItem() {
        TodoItem item = new TodoItem("Todo label", "Description", TodoPriority.HIGH, false, false);

        repository.save(item);
        Optional<TodoItem> byId = repository.findById(1);
        Assert.assertEquals("Todo label", byId.get().getLabel());
    }

    @Test
    public void getItems() {
        TodoItem item1 = new TodoItem("item1", "Description", TodoPriority.HIGH, false, false);
        TodoItem item2 = new TodoItem("item2", "Description", TodoPriority.HIGH, false, false);
        repository.save(item1);
        repository.save(item2);
        Assert.assertEquals(2, repository.findAll().size());
    }

    @Test
    public void updateItems() {
        TodoItem item = new TodoItem("item", "Description", TodoPriority.HIGH, false, false);
        TodoItem created = repository.save(item);
        created.setLabel("item_updated");
        repository.save(created);
        Assert.assertEquals("item_updated", repository.findById(created.getId()).get().getLabel());
    }

    @Test
    public void deleteItem() {
        TodoItem item = new TodoItem("item1", "Description", TodoPriority.HIGH, false, false);
        repository.save(item);
        repository.delete(item);
        Assert.assertTrue(repository.findAll().isEmpty());
    }
}
