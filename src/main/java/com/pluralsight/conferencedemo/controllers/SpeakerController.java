package com.pluralsight.conferencedemo.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController
{
   @Autowired
   private SpeakerRepository speakerRepository;

   @GetMapping
   public List<Speaker> list()
   {
      return speakerRepository.findAll();
   }

   @RequestMapping(value = "{id}", method = RequestMethod.GET)
   public Speaker get(@PathVariable Long id)
   {
      return speakerRepository.getById(id);
   }

   @PostMapping
   public Speaker create(@RequestBody
   final Speaker session)
   {
      return speakerRepository.saveAndFlush(session);
   }

   @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
   public void delete(@PathVariable Long id)
   {
      speakerRepository.deleteById(id);
   }

   @RequestMapping(value = "{id}", method = RequestMethod.PUT)
   public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker)
   {
      Speaker existingSpeaker = speakerRepository.getById(id);
      BeanUtils.copyProperties(speaker, existingSpeaker);
      return speakerRepository.saveAndFlush(existingSpeaker);
   }

}
