package com.tempo.tempehum.accessingdatapostgres.repository;
import com.tempo.tempehum.accessingdatapostgres.model.Timer;
import org.springframework.data.repository.CrudRepository;

public interface TimerRepository extends CrudRepository<Timer, Integer> {

}
