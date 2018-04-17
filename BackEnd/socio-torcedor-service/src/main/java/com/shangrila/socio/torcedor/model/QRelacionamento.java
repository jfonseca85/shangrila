package com.shangrila.socio.torcedor.model;

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
public class QRelacionamento extends EntityPathBase<Relacionamento> {

    private static final long serialVersionUID = 655577121L;

    public static final QRelacionamento campaing = new QRelacionamento("campaing");

    public final DateTimePath<LocalDate> dateEndCampaing = createDateTime("dateEndCampaing", LocalDate.class);

    public final DateTimePath<LocalDate> dateStartCampaing = createDateTime("dateStartCampaing", LocalDate.class);

    public final NumberPath<Integer> idCampaing = createNumber("idCampaing", Integer.class);

    public final NumberPath<Integer> idSoccerTeam = createNumber("idSoccerTeam", Integer.class);
    
    public final StringPath nomeCampanha = createString("nomeCampanha");

    public QRelacionamento(String variable) {
        super(Relacionamento.class, forVariable(variable));
    }

    public QRelacionamento(Path<? extends Relacionamento> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRelacionamento(PathMetadata metadata) {
        super(Relacionamento.class, metadata);
    }

}

