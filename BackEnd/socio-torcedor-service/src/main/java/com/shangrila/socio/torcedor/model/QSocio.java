package com.shangrila.socio.torcedor.model;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

/**
 * QSocio is a Querydsl query type for Socio
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSocio extends EntityPathBase<Socio> {

	private static final long serialVersionUID = 1620873843L;

	public static final QSocio socio = new QSocio("socio");

	public final DatePath<java.time.LocalDate> dateBirthday = createDate("dateBirthday", java.time.LocalDate.class);

	public final StringPath email = createString("email");

	public final NumberPath<Integer> idSoccerTeam = createNumber("idSoccerTeam", Integer.class);

	public final StringPath nameSoccer = createString("nameSoccer");


	public QSocio(String variable) {
		super(Socio.class, forVariable(variable));
	}

	public QSocio(Path<? extends Socio> path) {
		super(path.getType(), path.getMetadata());
	}

	public QSocio(PathMetadata metadata) {
		super(Socio.class, metadata);
	}

}
