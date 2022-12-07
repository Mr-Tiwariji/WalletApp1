//package com.WalletPaymentApp.controller;
//
//import java.util.List;
//
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.WalletPayment.Exception.WalletBadRequest;
//import com.WalletPaymentApp.Utility.WalletValidator;
//import com.WalletPaymentApp.model.Wallet;
//import com.WalletPaymentApp.repository.TransactionRepository;
//import com.WalletPaymentApp.repository.WalletRepository;
//
//import ch.qos.logback.classic.Logger;
//
//@RestController
//public class WalletController {
//	
//	@Autowired
//	private WalletRepository walletRepository;
//	@Autowired
//	private TransactionRepository tranrepository;
//	
//	
//	
//	
//	
//	
//	WalletValidator walletvalidator =new WalletValidator();
//	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WalletController.class);
//	
//	
//    @GetMapping("/findAllWallet")
//    List<Wallet> findAllWallet() {
//        return walletRepository.findAll();
//    }
//    
//    //creating a wallet
//    
//    @PostMapping("/createNewWallet")
//    //return 201 instead of 200
//    //@ResponseStatus(Https)
//    
//    Wallet CreateNewWallet(@RequestBody Wallet newWallet) {
//        if (!walletvalidator.validateWalletRequest(newWallet)) {
//            logger.info("CreateNewWallet request not valid");
//            throw new WalletBadRequest();
//        }
//        Wallet wallet = walletRepository.save(newWallet);
//        return wallet;
//    }
//    
//    //updating a wallet
//    @PutMapping("/updateWallet")
//    
//    Wallet updateWallet(@RequestBody Wallet newWallet) {
//        Wallet wallet = walletRepository.save(newWallet);
//        return wallet;
//    }
//}
