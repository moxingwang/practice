package top.moxingwang.springbootfeature.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import top.moxingwang.springbootfeature.model.TxOrderEntity;

import java.util.Optional;

/**
 * @description:
 * @author: MoXingwang 2019-08-01 14:05
 **/
public interface  OrderRepository extends JpaRepository<TxOrderEntity, Long> {
    Optional<TxOrderEntity> findById(Long id);


}
