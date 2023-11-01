package ru.santurov.accountingcrud.dto;

import lombok.Data;
import ru.santurov.accountingcrud.models.Corpus;
import ru.santurov.accountingcrud.models.Floor;

@Data
public class RoomDTO {
    private Long id;

    private int number;

    private String name;

    private Long corps;

    private float width;

    private float length;

    private Long floorNumber;
}
