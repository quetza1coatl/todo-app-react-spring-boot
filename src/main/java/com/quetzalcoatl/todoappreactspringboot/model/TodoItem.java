package com.quetzalcoatl.todoappreactspringboot.model;

import com.quetzalcoatl.todoappreactspringboot.util.TodoPriority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoItem extends AbstractBaseEntity{

    private String label;

    private String description;

    @Enumerated(EnumType.STRING)
    private TodoPriority priority;

    private Boolean isDone;

    private Boolean isOnControl;
}
