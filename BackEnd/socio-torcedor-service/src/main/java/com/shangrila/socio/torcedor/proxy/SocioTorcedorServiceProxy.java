package com.shangrila.socio.torcedor.proxy;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shangrila.socio.torcedor.model.Relacionamento;

//@FeignClient(name="marketing-campaing-service", url="localhost:8200")
@FeignClient(name="marketing-campaing-service")
//@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface SocioTorcedorServiceProxy {
	@GetMapping("/marketing-campaing-service/campaings?idTeamSoccer={idTeamSoccer}")
	public Optional<List<Relacionamento>> retrieveTeams( @RequestParam MultiValueMap<String,String> uriVariables);
}
