package net.woolgens.changelogs.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import net.woolgens.changelogs.model.Changelog;

import javax.enterprise.context.ApplicationScoped;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@ApplicationScoped
public class ChangelogsRepository implements PanacheMongoRepositoryBase<Changelog, String> {
}
