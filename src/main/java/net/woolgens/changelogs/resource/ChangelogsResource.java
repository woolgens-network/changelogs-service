package net.woolgens.changelogs.resource;

import net.woolgens.changelogs.exception.ChangelogsException;
import net.woolgens.changelogs.model.Changelog;
import net.woolgens.changelogs.repository.ChangelogsRepository;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/changelogs/")
public class ChangelogsResource {

    @Inject
    ChangelogsRepository repository;

    @GET
    public List<Changelog> getAll() {
        return repository. listAll();
    }

    @GET
    @Path("{id}")
    public Changelog get(@PathParam("id") String id) throws ChangelogsException {
        Optional<Changelog> optional = repository.findByIdOptional(id);
        if(!optional.isPresent()) {
            throw new ChangelogsException(404, "Changelog not found");
        }
        return optional.get();
    }

    @PUT
    @RolesAllowed("Admin")
    public Changelog put(Changelog changelog) {
        repository.persistOrUpdate(changelog);
        return changelog;
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") String id) {
        return repository.deleteById(id);
    }
}