package id.demo.crude.aspect;

import id.demo.crude.AppCore;
import id.demo.crude.common.Result;
import id.demo.crude.entity.Kabupaten;
import id.demo.crude.exception.UploadFailedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Aspect
@Component
public class AspectService {

    @Around("execution(* id.demo.crude.service.*.save(..))")
    public Result processSave(ProceedingJoinPoint joinPoint) throws Throwable {
        AppCore.getLogger(this).info("***AspectJ*** save is catch !! intercepted : " + joinPoint.getSignature());
        if (joinPoint.getArgs()[0] instanceof Kabupaten) {
            Kabupaten object = (Kabupaten) joinPoint.getArgs()[0];
            return new Result(validateSaveMethod(joinPoint), object);
        }

        return new Result(validateSaveMethod(joinPoint));  //some method have no register yet or some method no need register with specific treatment just around here
    }

    private String validateSaveMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            joinPoint.proceed();
            return Result.SAVE_SUCCESS;
        } catch (DuplicateKeyException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            AppCore.getLogger(this).error(e.getMessage());
            return Result.SAVE_DATA_EXIST;
        } catch (DataAccessException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            AppCore.getLogger(this).error(e.getMessage());
            return Result.DB_EXCEPTION;
        } catch (UploadFailedException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            AppCore.getLogger(this).error(e.getMessage());
            return Result.UPLOAD_FAILED;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            AppCore.getLogger(this).error(e.getCause().getMessage());
            return Result.SYSTEM_EXCEPTION;
        }
    }

    @Around("execution(* id.demo.crude.service.*.delete(..))")
    public Result processDelete(ProceedingJoinPoint joinPoint) throws Throwable {
        AppCore.getLogger(this).info("***AspectJ*** delete is catch !! intercepted : " + joinPoint.getSignature());
        return new Result(validateDeleteMethod(joinPoint));
    }

    private String validateDeleteMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            joinPoint.proceed();
            return Result.DELETE_SUCCESS;
        } catch (DataAccessException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            AppCore.getLogger(this).error(e.getMessage());
            return Result.DB_EXCEPTION;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            AppCore.getLogger(this).error(e.getMessage());
            return Result.SYSTEM_EXCEPTION;
        }
    }

}
