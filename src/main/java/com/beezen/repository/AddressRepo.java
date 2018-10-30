package com.beezen.repository;
import org.springframework.data.repository.CrudRepository;

import com.beezen.domain.Address;

public interface AddressRepo  extends CrudRepository<Address, Long> {

}
