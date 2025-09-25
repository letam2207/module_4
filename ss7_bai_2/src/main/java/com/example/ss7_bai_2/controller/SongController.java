package com.example.ss7_bai_2.controller;

import com.example.ss7_bai_2.dto.SongDto;
import com.example.ss7_bai_2.entity.Song;
import com.example.ss7_bai_2.service.ISongService;
import com.example.ss7_bai_2.validation.SongValidation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    private final ISongService songService;

    public SongController(ISongService songService){
        this.songService = songService;
    }

    @GetMapping
    public String getAllSong(Model model) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "song/list";
    }

    @GetMapping("/create")
    public String createSong(ModelMap model) {
        model.addAttribute("songDto", new SongDto());
        return "song/create";
    }

    @PostMapping("/create")
    public String createSong(@Validated @ModelAttribute("songDto") SongDto songDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirect) {
        new SongValidation().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "song/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/song";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Song song = songService.findById(id);
        if (song == null) {
            return "redirect:/song";
        }
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", songDto);
        model.addAttribute("id", id);
        return "song/update";
    }

    @PostMapping("/update/{id}")
    public String updateSong(@PathVariable("id") Integer id,
                             @Validated @ModelAttribute("songDto") SongDto songDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirect) {
        new SongValidation().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "song/update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        song.setId(id);
        songService.update(song);
        redirect.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/song";
    }

}
