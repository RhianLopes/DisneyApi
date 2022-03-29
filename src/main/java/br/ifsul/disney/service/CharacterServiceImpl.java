package br.ifsul.disney.service;

import br.ifsul.disney.dto.CharacterDetailResponseDto;
import br.ifsul.disney.dto.CharacterResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private static final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<String> getCharacterNames() {
        ResponseEntity<CharacterResponseDto> response = restTemplate.getForEntity("https://api.disneyapi.dev/characters", CharacterResponseDto.class);
        return response.getBody().getData().stream()
                .map(CharacterDetailResponseDto::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getCharacterMovies() {
        ResponseEntity<CharacterResponseDto> response = restTemplate.getForEntity("https://api.disneyapi.dev/characters", CharacterResponseDto.class);
        return response.getBody().getData().stream()
                .map(CharacterDetailResponseDto::getFilms)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public String getCharacters() {
        ResponseEntity<CharacterResponseDto> result = restTemplate.getForEntity("https://api.disneyapi.dev/characters", CharacterResponseDto.class);
        final StringBuilder response = new StringBuilder();
        result.getBody().getData()
                .forEach(character -> response.append("<div><h1>").append(character.getName()).append("</h1><img src=\"").append(character.getImageUrl()).append("\"></div>"));
        return response.toString();
    }
}
