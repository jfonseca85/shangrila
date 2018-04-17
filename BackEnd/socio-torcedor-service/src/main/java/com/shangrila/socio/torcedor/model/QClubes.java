package com.shangrila.socio.torcedor.model;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;


/**
 * QSocio is a Querydsl query type for clubes
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClubes extends EntityPathBase<Socio> {

    private static final long serialVersionUID = 1620873843L;

    public static final QClubes clubes = new QClubes("clubes");

    public final NumberPath<Integer> idSoccerTeam = createNumber("idSoccerTeam", Integer.class);

    public final StringPath nomeClube = createString("nomeClube");

    public final StringPath descUsuario = createString("descUsuario");

    public QClubes(String variable) {
        super(Socio.class, forVariable(variable));
    }

    public QClubes(Path<? extends Socio> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClubes(PathMetadata metadata) {
        super(Socio.class, metadata);
    }

}

