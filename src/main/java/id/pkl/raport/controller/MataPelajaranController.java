package id.pkl.raport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import id.pkl.raport.entity.MataPelajaran;
import id.pkl.raport.repository.MataPelajaranRepository;

@RestController
@RequestMapping(value="/matapelajaran")
public class MataPelajaranController {
	@Autowired
	private MataPelajaranRepository mataPelajaranRepository;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<MataPelajaran> addMataPelajaran(@Validated @RequestBody MataPelajaran mataPelajaran, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<MataPelajaran> (HttpStatus.BAD_REQUEST);
		}
		
		MataPelajaran newMatpel = mataPelajaranRepository.save(mataPelajaran);
		return new ResponseEntity<MataPelajaran>(newMatpel, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<MataPelajaran> listMatpel(Pageable pageable)
	{
		return mataPelajaranRepository.findAll(pageable);
	}
	
	
}
