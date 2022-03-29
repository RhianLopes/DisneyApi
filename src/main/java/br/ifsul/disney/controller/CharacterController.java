package br.ifsul.disney.controller;

import br.ifsul.disney.dto.CharacterDetailResponseDto;
import br.ifsul.disney.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping("/names")
    public List<String> searchCharacterNames() {
        return characterService.getCharacterNames();
    }

    @GetMapping("/movies")
    public List<String> searchCharacterMovies() {
        return characterService.getCharacterMovies();
    }

    @GetMapping
    public String searchCharacters() {
        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<body>\n" + characterService.getCharacters() + "</body>\n" + "</html>";
    }
}
