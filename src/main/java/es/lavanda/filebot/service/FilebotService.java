package es.lavanda.filebot.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import es.lavanda.filebot.exception.FilebotException;
import es.lavanda.filebot.model.Filebot;
import es.lavanda.filebot.model.FilebotFile;
import es.lavanda.filebot.repository.FilebotFileRepository;
import es.lavanda.filebot.repository.FilebotRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FilebotService {

    @Autowired
    private FilebotRepository filebotRepository;

    public Page<Filebot> getAllPageable(Pageable pageable) {
        return filebotRepository.findAllByOrderByLastModifiedAtDesc(pageable);
    }

}