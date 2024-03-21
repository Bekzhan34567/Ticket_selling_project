package kg.alatoo.ticketsellingapp.controllers;

import kg.alatoo.ticketsellingapp.dto.TicketDTO;
import kg.alatoo.ticketsellingapp.services.TicketService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.Optional;

public class TicketApiController {

    private final Logger log = LogManager.getLogger(TicketApiController.class);
    private final String API_PATH = "/api/v1/";
    private final String PATH = API_PATH + "ticket";
    private final String ID_PATH = PATH + "/{id}";

    private final TicketService ticketService;

    public TicketApiController(TicketService ticketService) {
        this.ticketService = ticketService;
    }



    @GetMapping(ID_PATH)
    public Optional<TicketDTO> getById(@PathVariable Long id) {
        log.info("Getting book with id:" + id);
        return ticketService.findTicketByID(id);
    }


    @PostMapping(PATH)
    public ResponseEntity<TicketDTO> createTicket(@Validated @RequestBody TicketDTO ticketDTO) {
        TicketDTO dto = ticketService.saveTicket(ticketDTO);

        return ResponseEntity.created(URI.create(PATH + "/"+dto.getId())).body(dto);
    }

}
