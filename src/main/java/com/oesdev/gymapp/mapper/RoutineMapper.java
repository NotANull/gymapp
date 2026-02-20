package com.oesdev.gymapp.mapper;

import com.oesdev.gymapp.dto.request.CreateRoutineRequest;
import com.oesdev.gymapp.dto.response.RoutineDetailsResponse;
import com.oesdev.gymapp.entity.Routine;
import org.springframework.stereotype.Component;

@Component
public class RoutineMapper {

    public Routine toRoutineEntity(CreateRoutineRequest request) {

        return new Routine(
                request.getName(),
                request.getSets(),
                request.getReps(),
                request.getRest(),
                request.getLoad(),
                request.getFrequency()
        );

    }

    public RoutineDetailsResponse toRoutineResponse(Routine routineEntity) {

        return new RoutineDetailsResponse(
                routineEntity.getId(),
                routineEntity.getName(),
                routineEntity.getSets(),
                routineEntity.getReps(),
                routineEntity.getRest(),
                routineEntity.getLoad(),
                routineEntity.getFrequency()
        );

    }

}
