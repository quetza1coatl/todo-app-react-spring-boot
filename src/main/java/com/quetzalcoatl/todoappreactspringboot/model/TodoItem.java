package com.quetzalcoatl.todoappreactspringboot.model;

import com.quetzalcoatl.todoappreactspringboot.util.TodoPriority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String label;

    private String description;

    @Enumerated(EnumType.STRING)
    private TodoPriority priority;

    private Boolean isDone;

    private Boolean isOnControl;
}
