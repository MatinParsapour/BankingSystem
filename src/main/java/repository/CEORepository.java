package repository;

import base.repository.BaseRepository;
import domain.CEO;

public interface CEORepository extends BaseRepository<CEO, Long> {
    CEO findCEOByCEOId(int cEOCode);
}
