//package com.WalletPaymentApp.controller;
//
//import java.time.LocalDate;
//import java.util.Calendar;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.WalletPayment.Exception.TransactionBadRequest;
//import com.WalletPaymentApp.Utility.TransactionValidator;
//import com.WalletPaymentApp.Utility.WalletValidator;
//import com.WalletPaymentApp.model.Transaction;
//import com.WalletPaymentApp.model.User;
//import com.WalletPaymentApp.model.Wallet;
//import com.WalletPaymentApp.repository.TransactionRepository;
//import com.WalletPaymentApp.repository.WalletRepository;
//import com.WalletPaymentApp.services.UserService;
//
//@RestController
//public class TransactionController {
//	
//	@Autowired
//	private WalletRepository walletRepository;
//	@Autowired
//    private TransactionRepository tranrepository;
//	
//	@Autowired
//    private UserService userService;
//	
//	
//	WalletValidator walletValidator = new WalletValidator();
//    TransactionValidator validator = new TransactionValidator();
//    private static final String TOPIC = "test";
//    private static final Logger logger = LoggerFactory.getLogger(WalletResource.class);
//    
//    
//    //Sending money 
//    
//    @PostMapping("/sendMoney")
//    
//    //@ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    Transaction sendMoney(@RequestBody Transaction transaction) throws Exception {
//
//        if (!validator.validateRequest(transaction)) {
//            throw new TransactionBadRequest();
//        }
//        //transaction.setDate(new LocalDate(Calendar.getInstance().getTime().getTime()));
//        User sender = userService.getAUser(String.valueOf(transaction.getWallet_id()));
//        User receiver = userService.getAUser(String.valueOf(transaction.getWallet_id()));
//        if (sender == null || receiver == null) {
//            logger.info("No wallet for sender or receiver");
//            throw new TransactionBadRequest();
//        }
//
//        Wallet senderWallet = walletRepository.findWalletByUserId(sender.getId());
//        Wallet receiverWallet = walletRepository.findWalletByUserId(receiver.getId());
//
//        double amt = transaction.getAmount();
//
//        if (senderWallet.getBalance() < amt) {
//            throw new Exception("Not Sufficient Balance");
//        }
//        senderWallet.setBalance(senderWallet.getBalance() - amt);
//
//        receiverWallet.setBalance(receiverWallet.getBalance() + amt);
//
//        transaction.setStatus("SUCCESS");
//        logger.info(String.format("$$ -> Producing Transaction --> %s", transaction));
//        walletRepository.save(receiverWallet);
//        walletRepository.save(senderWallet);
//        return tranrepository.save(transaction);
//    }
//    
//    //Getting the balance
//    
//    @GetMapping("/getBal/{id}")
//    double getBal(@PathVariable int id) throws Exception {
//
//        Wallet wallet = walletRepository.findWalletByUserId(id);
//
//        if (wallet == null) {
//            throw new Exception("Wallet Not Found");
//        } else {
//            return wallet.getBalance();
//        }
//    }
//    
//    //adding balance
//    @PostMapping("/addBalance")
//    Wallet addBalance(@RequestBody Wallet request) {
//
//        logger.info(request.toString());
//        Wallet wallet = walletRepository.findWalletByUserId(request.getUser_id());
//
//        wallet.setBalance(request.getBalance() + wallet.getBalance());
//        walletRepository.save(wallet);
//        return request;
//    }
//    
//    
//
//}
