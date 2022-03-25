package com.abiha.springcloud.couponservice.controllers;

import com.abiha.springcloud.couponservice.model.Coupon;
import com.abiha.springcloud.couponservice.repo.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

    @Autowired
    CouponRepo repo;

    @PostMapping("/coupons")
    public Coupon create(@RequestBody Coupon coupon){
        return repo.save(coupon);
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable("code") String code){
        return repo.findByCode(code);
    }
}
