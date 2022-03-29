package br.ifsul.disney.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDetailResponseDto {

    private List<String> films;

    private String name;

    private String imageUrl;

}
