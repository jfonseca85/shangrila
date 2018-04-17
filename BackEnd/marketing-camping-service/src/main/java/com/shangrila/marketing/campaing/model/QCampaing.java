package com.shangrila.marketing.campaing.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import java.time.LocalDate;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCampaing is a Querydsl query type for Campaing
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCampaing extends EntityPathBase<Campaing> {

    private static final long serialVersionUID = 655577121L;

    public static final QCampaing campaing = new QCampaing("campaing");

    public final DateTimePath<LocalDate> dateEndCampaing = createDateTime("dateEndCampaing", LocalDate.class);

    public final DateTimePath<LocalDate> dateStartCampaing = createDateTime("dateStartCampaing", LocalDate.class);

    public final NumberPath<Integer> idCampaing = createNumber("idCampaing", Integer.class);

    public final NumberPath<Integer> idSoccerTeam = createNumber("idSoccerTeam", Integer.class);
    
    public final StringPath nomeCampanha = createString("nomeCampanha");

    public QCampaing(String variable) {
        super(Campaing.class, forVariable(variable));
    }

    public QCampaing(Path<? extends Campaing> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCampaing(PathMetadata metadata) {
        super(Campaing.class, metadata);
    }

}

