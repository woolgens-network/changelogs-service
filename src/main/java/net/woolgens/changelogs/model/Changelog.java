package net.woolgens.changelogs.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;

import java.util.List;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@Data
@MongoEntity(collection = "changelogs")
public class Changelog {

    @BsonId
    private String id;

    private String title;
    private String author;
    private long timestamp;
    private List<String> lines;

}
