package com.greenjourneys.controller;

import com.greenjourneys.entities.Transport;
import com.greenjourneys.entities.Type_Moyen;
import com.greenjourneys.services.ITransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
public class TransportCont {

    @Autowired
    ITransportService transportService;

    @GetMapping(value = "/transport/getAll")
    @ResponseBody
    List<Transport> getAll() {
        return transportService.retrieveAll();
    }

    @GetMapping(value = "/transport/getById/{id}")
    @ResponseBody
    Transport getById(@PathVariable("id") Integer id) {
        return transportService.retrieveById(id);
    }

    @PostMapping(value = "/transport/gasConsumption")
    @ResponseBody
    List<Double> gasConsumption(@RequestBody List<Integer> listIds) {

        List<Double> gasConsumptions = new ArrayList<>();

        listIds.forEach(idTransport -> {
            double gasConsu;
            Transport transport = transportService.retrieveById(idTransport);
            switch (transport.getType_moyen()) {
                case Train:
                    gasConsu = transport.getDistance() / 0.006;
                    break;
                case Bus:
                    gasConsu = transport.getDistance() / 0.4;
                    break;
                case Metro:
                    gasConsu = 0.0;
                    break;
                case Avion:
                    gasConsu = transport.getDistance() / 7.57082;
                    break;
                case Voiture:
                    gasConsu = transport.getDistance() / 0.12;
                    break;
                default:
                    gasConsu = 0.0;
                    break;
            }
            gasConsumptions.add(gasConsu);

        });
        return gasConsumptions;
    }


    @PostMapping(value = "/transport/add")
    @ResponseBody
    Transport add(@RequestBody Transport transport) {
        return transportService.add(transport);
    }

    @PutMapping(value = "/transport/update")
    @ResponseBody
    Transport update(@RequestBody Transport transport) {
        return transportService.update(transport);
    }

    @DeleteMapping(value = "/transport/delete/{id}")
    @ResponseBody
    Boolean delete(@PathVariable("id") Integer id) {
        return transportService.delete(id);
    }
}
