package com.springdemo.flightsMVCCRUDApplication;

import com.springdemo.flightsMVCCRUDApplication.model.Flight;
import com.springdemo.flightsMVCCRUDApplication.service.FlightService;

import jakarta.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/flight")
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){

        StringTrimmerEditor ste = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, ste);

    }

    @GetMapping("/list")
    public String get(Model model){
        List<Flight> flights = flightService.findAll();
        model.addAttribute("flights",flights);
        return "flights/flight-list";
    }

    @GetMapping("/addForm")
    public String add(Model model){
        Flight flight = new Flight();
        model.addAttribute("flight", flight);
        return "flights/add-form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("flight") Flight flight,BindingResult br){
        if(br.hasErrors()){
            return "flights/add-form";
        }
        else{
            flightService.save(flight);
            return "redirect:/flight/list";
        }
        
    }

    @GetMapping("/update")
    public String update(@RequestParam("tempFlightNo") String flightNo,Model model){
        Flight flight = flightService.findById(flightNo);
        model.addAttribute("flight", flight);
        return "flights/add-form";

    }
    @GetMapping("/delete")
    public String delete(@RequestParam("tempFlightNo") String flightNo){
        flightService.deleteById(flightNo);
        return"redirect:/flight/list";

    }
}
