package me.lebedamm.coursework3.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.lebedamm.coursework3.dto.ResponseDto;
import me.lebedamm.coursework3.exception.ValException;
import me.lebedamm.coursework3.model.Color;
import me.lebedamm.coursework3.model.Pack;
import me.lebedamm.coursework3.model.Size;
import me.lebedamm.coursework3.services.FirstService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.SimpleTimeZone;

@RestController
@RequestMapping ("/api/socks")
@Tag( name = "Файлы", description = "Работа с файлами")
public class FirstController {
    private final FirstService firstService;

    @Operation (summary = "Добавление", description = "Регистрация прихода товара")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Удалось добавить приход"),
            @ApiResponse(responseCode = "400", description = "Параметры запроса отсуствуют или имеют неккоректный ввод"),
            @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны")
    })

    public ResponseEntity<ResponseDto> addSocks(@RequestBody Pack pack ) {
        firstService.accept(pack);
        return ResponseEntity.ok(new ResponseDto("Успешно добавлено"));
    }


    @Operation (summary = "Забрать", description = "Регистрация забора носков")
    @PutMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Удалось забрать приход"),
            @ApiResponse(responseCode = "400", description = "Параметры запроса отсуствуют или имеют неккоректный ввод"),
            @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны")
    })

    public ResponseEntity<ResponseDto> releaseSocks(@RequestBody Pack pack) {
        int socksCount = firstService.release(pack);
        return ResponseEntity.ok(new ResponseDto(socksCount + " - штук списано"));
    }

    @Operation (summary = "Остаток", description = "Показывает кол-во новсков на складе")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Операция выполнена"),
            @ApiResponse(responseCode = "400", description = "Параметры запроса отсуствуют или имеют неккоректный ввод"),
            @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны")
    })

    public ResponseEntity<ResponseDto> getSocks(@RequestBody Color color,
                                                @RequestBody Size size,
                                                @RequestBody int percentCottonMax,
                                                @RequestBody int percentCottonMin) {
        int socksCount = firstService.getRemains(color,size,percentCottonMin,percentCottonMax);
        return ResponseEntity.ok(new ResponseDto(socksCount + " - штук на складе"));
    }

    @Operation (summary = "Списание", description = "Учет брака")
    @DeleteMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Операция выполнена"),
            @ApiResponse(responseCode = "400", description = "Параметры запроса отсуствуют или имеют неккоректный ввод"),
            @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны")
    })

    public ResponseEntity <ResponseDto> deleteSocks (@RequestBody Pack pack) {
        int socksCount = firstService.delete(pack);
        return ResponseEntity.ok(new ResponseDto(socksCount + " - штук списано"));
    }



    public FirstController(FirstService firstService) {
        this.firstService = firstService;


    }
}
