package com.example.fiscodemo3.contract;

import org.fisco.bcos.sdk.v3.client.Client;
import org.fisco.bcos.sdk.v3.codec.datatypes.*;
import org.fisco.bcos.sdk.v3.codec.datatypes.generated.Uint256;
import org.fisco.bcos.sdk.v3.codec.datatypes.generated.tuples.generated.Tuple2;
import org.fisco.bcos.sdk.v3.contract.Contract;
import org.fisco.bcos.sdk.v3.crypto.CryptoSuite;
import org.fisco.bcos.sdk.v3.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.v3.model.CryptoType;
import org.fisco.bcos.sdk.v3.model.TransactionReceipt;
import org.fisco.bcos.sdk.v3.model.callback.TransactionCallback;
import org.fisco.bcos.sdk.v3.transaction.model.exception.ContractException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
public class Register extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b50610967806100206000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c80631d2e4afd1461005c57806322ce12e514610071578063502c9bd514610084578063a87430ba146100b4578063b5cb15f7146100d5575b600080fd5b61006f61006a36600461071f565b6100e6565b005b61006f61007f36600461071f565b6102f3565b610097610092366004610783565b61048d565b6040516001600160a01b0390911681526020015b60405180910390f35b6100c76100c236600461079c565b6104b7565b6040516100ab929190610819565b6001546040519081526020016100ab565b60008251116101375760405162461bcd60e51b8152602060048201526018602482015277557365726e616d652063616e6e6f7420626520656d70747960401b60448201526064015b60405180910390fd5b60008151116101835760405162461bcd60e51b815260206004820152601860248201527750617373776f72642063616e6e6f7420626520656d70747960401b604482015260640161012e565b604080516020808201835260009182905233825281905281902090517fc5d2460186f7233c927e7db2dcc703c0e500b653ca82273b7bfad8045d85a470916101ca91610882565b60405180910390201461021f5760405162461bcd60e51b815260206004820152601760248201527f5573657220616c72656164792072656769737465726564000000000000000000604482015260640161012e565b604080518082018252838152602080820184905233600090815280825292909220815180519293919261025592849201906105e3565b50602082810151805161026e92600185019201906105e3565b50506001805480820182556000919091527fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf60180546001600160a01b031916339081179091556040519091507f48cac28ad4dc618e15f4c2dd5e97751182f166de97b25618318b2112aa951a2f906102e790859061091e565b60405180910390a25050565b600082511161033f5760405162461bcd60e51b8152602060048201526018602482015277557365726e616d652063616e6e6f7420626520656d70747960401b604482015260640161012e565b600081511161038b5760405162461bcd60e51b815260206004820152601860248201527750617373776f72642063616e6e6f7420626520656d70747960401b604482015260640161012e565b336000908152602081815260409182902084519185019190912091519091906103b5908390610882565b6040518091039020146103fd5760405162461bcd60e51b815260206004820152601060248201526f496e76616c696420757365726e616d6560801b604482015260640161012e565b81516020830120604051610415906001840190610882565b60405180910390201461045d5760405162461bcd60e51b815260206004820152601060248201526f125b9d985b1a59081c185cdcdddbdc9960821b604482015260640161012e565b60405133907f8d15fde878cff665868ed7579eb5081db6508d4249df61dcdd7699a5301d987490600090a2505050565b6001818154811061049d57600080fd5b6000918252602090912001546001600160a01b0316905081565b6000602081905290815260409020805481906104d290610847565b80601f01602080910402602001604051908101604052809291908181526020018280546104fe90610847565b801561054b5780601f106105205761010080835404028352916020019161054b565b820191906000526020600020905b81548152906001019060200180831161052e57829003601f168201915b50505050509080600101805461056090610847565b80601f016020809104026020016040519081016040528092919081815260200182805461058c90610847565b80156105d95780601f106105ae576101008083540402835291602001916105d9565b820191906000526020600020905b8154815290600101906020018083116105bc57829003601f168201915b5050505050905082565b8280546105ef90610847565b90600052602060002090601f0160209004810192826106115760008555610657565b82601f1061062a57805160ff1916838001178555610657565b82800160010185558215610657579182015b8281111561065757825182559160200191906001019061063c565b50610663929150610667565b5090565b5b808211156106635760008155600101610668565b634e487b7160e01b600052604160045260246000fd5b600082601f8301126106a357600080fd5b813567ffffffffffffffff808211156106be576106be61067c565b604051601f8301601f19908116603f011681019082821181831017156106e6576106e661067c565b816040528381528660208588010111156106ff57600080fd5b836020870160208301376000602085830101528094505050505092915050565b6000806040838503121561073257600080fd5b823567ffffffffffffffff8082111561074a57600080fd5b61075686838701610692565b9350602085013591508082111561076c57600080fd5b5061077985828601610692565b9150509250929050565b60006020828403121561079557600080fd5b5035919050565b6000602082840312156107ae57600080fd5b81356001600160a01b03811681146107c557600080fd5b9392505050565b6000815180845260005b818110156107f2576020818501810151868301820152016107d6565b81811115610804576000602083870101525b50601f01601f19169290920160200192915050565b60408152600061082c60408301856107cc565b828103602084015261083e81856107cc565b95945050505050565b600181811c9082168061085b57607f821691505b6020821081141561087c57634e487b7160e01b600052602260045260246000fd5b50919050565b600080835481600182811c91508083168061089e57607f831692505b60208084108214156108be57634e487b7160e01b86526022600452602486fd5b8180156108d257600181146108e357610910565b60ff19861689528489019650610910565b60008a81526020902060005b868110156109085781548b8201529085019083016108ef565b505084890196505b509498975050505050505050565b6020815260006107c560208301846107cc56fea2646970667358221220ebe2bfda171c684ce9865206322087ad2bca824dd9b2f712adaa0f8189d4729364736f6c634300080b0033"};

    public static final String BINARY = org.fisco.bcos.sdk.v3.utils.StringUtils.joinAll("", BINARY_ARRAY);

    public static final String[] SM_BINARY_ARRAY = {"608060405234801561001057600080fd5b5061096e806100206000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c806326f640291461005c5780633abae6e514610071578063684b4289146100875780636ade0b9d146100a8578063e17be8ad146100bb575b600080fd5b61006f61006a366004610726565b6100e6565b005b6001546040519081526020015b60405180910390f35b61009a61009536600461078a565b610289565b60405161007e929190610807565b61006f6100b6366004610726565b6103b5565b6100ce6100c9366004610835565b6105c0565b6040516001600160a01b03909116815260200161007e565b600082511161013857604051636381e58960e11b8152602060048201526018602482015277557365726e616d652063616e6e6f7420626520656d70747960401b60448201526064015b60405180910390fd5b600081511161018557604051636381e58960e11b815260206004820152601860248201527750617373776f72642063616e6e6f7420626520656d70747960401b604482015260640161012f565b336000908152602081815260409182902084519185019190912091519091906101af908390610889565b6040518091039020146101f857604051636381e58960e11b815260206004820152601060248201526f496e76616c696420757365726e616d6560801b604482015260640161012f565b81516020830120604051610210906001840190610889565b60405180910390201461025957604051636381e58960e11b815260206004820152601060248201526f125b9d985b1a59081c185cdcdddbdc9960821b604482015260640161012f565b60405133907fdca0ff672b360de3292208f1e5b738dbd7e14409d8843668a7a3ac868765646090600090a2505050565b6000602081905290815260409020805481906102a49061084e565b80601f01602080910402602001604051908101604052809291908181526020018280546102d09061084e565b801561031d5780601f106102f25761010080835404028352916020019161031d565b820191906000526020600020905b81548152906001019060200180831161030057829003601f168201915b5050505050908060010180546103329061084e565b80601f016020809104026020016040519081016040528092919081815260200182805461035e9061084e565b80156103ab5780601f10610380576101008083540402835291602001916103ab565b820191906000526020600020905b81548152906001019060200180831161038e57829003601f168201915b5050505050905082565b600082511161040257604051636381e58960e11b8152602060048201526018602482015277557365726e616d652063616e6e6f7420626520656d70747960401b604482015260640161012f565b600081511161044f57604051636381e58960e11b815260206004820152601860248201527750617373776f72642063616e6e6f7420626520656d70747960401b604482015260640161012f565b604080516020808201835260009182905233825281905281902090517f1ab21d8355cfa17f8e61194831e81a8f22bec8c728fefb747ed035eb5082aa2b9161049691610889565b6040518091039020146104ec57604051636381e58960e11b815260206004820152601760248201527f5573657220616c72656164792072656769737465726564000000000000000000604482015260640161012f565b604080518082018252838152602080820184905233600090815280825292909220815180519293919261052292849201906105ea565b50602082810151805161053b92600185019201906105ea565b50506001805480820182556000919091527f801412028db4471413ca17a15806a4f6857ca4e7c2783885b524c92c7efcdc980180546001600160a01b031916339081179091556040519091507f0c9b2941507fd9b995c138ae0ae190b611a44d203429fc85dbd1a8fa0270827c906105b4908590610925565b60405180910390a25050565b600181815481106105d057600080fd5b6000918252602090912001546001600160a01b0316905081565b8280546105f69061084e565b90600052602060002090601f016020900481019282610618576000855561065e565b82601f1061063157805160ff191683800117855561065e565b8280016001018555821561065e579182015b8281111561065e578251825591602001919060010190610643565b5061066a92915061066e565b5090565b5b8082111561066a576000815560010161066f565b63b95aa35560e01b600052604160045260246000fd5b600082601f8301126106aa57600080fd5b813567ffffffffffffffff808211156106c5576106c5610683565b604051601f8301601f19908116603f011681019082821181831017156106ed576106ed610683565b8160405283815286602085880101111561070657600080fd5b836020870160208301376000602085830101528094505050505092915050565b6000806040838503121561073957600080fd5b823567ffffffffffffffff8082111561075157600080fd5b61075d86838701610699565b9350602085013591508082111561077357600080fd5b5061078085828601610699565b9150509250929050565b60006020828403121561079c57600080fd5b81356001600160a01b03811681146107b357600080fd5b9392505050565b6000815180845260005b818110156107e0576020818501810151868301820152016107c4565b818111156107f2576000602083870101525b50601f01601f19169290920160200192915050565b60408152600061081a60408301856107ba565b828103602084015261082c81856107ba565b95945050505050565b60006020828403121561084757600080fd5b5035919050565b600181811c9082168061086257607f821691505b602082108114156108835763b95aa35560e01b600052602260045260246000fd5b50919050565b600080835481600182811c9150808316806108a557607f831692505b60208084108214156108c55763b95aa35560e01b86526022600452602486fd5b8180156108d957600181146108ea57610917565b60ff19861689528489019650610917565b60008a81526020902060005b8681101561090f5781548b8201529085019083016108f6565b505084890196505b509498975050505050505050565b6020815260006107b360208301846107ba56fea2646970667358221220c60e4d88aaaf1cc5cef6b75699123e9761ba6f146eff1447e400c8b4b8ae2fc864736f6c634300080b0033"};

    public static final String SM_BINARY = org.fisco.bcos.sdk.v3.utils.StringUtils.joinAll("", SM_BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"internalType\":\"address\",\"name\":\"userAddress\",\"type\":\"address\"}],\"name\":\"UserLoggedIn\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"internalType\":\"address\",\"name\":\"userAddress\",\"type\":\"address\"},{\"indexed\":false,\"internalType\":\"string\",\"name\":\"username\",\"type\":\"string\"}],\"name\":\"UserRegistered\",\"type\":\"event\"},{\"conflictFields\":[{\"kind\":4,\"value\":[1]}],\"inputs\":[],\"name\":\"getUserCount\",\"outputs\":[{\"internalType\":\"uint256\",\"name\":\"\",\"type\":\"uint256\"}],\"selector\":[3049985527,985327333],\"stateMutability\":\"view\",\"type\":\"function\"},{\"conflictFields\":[{\"kind\":0},{\"kind\":2,\"slot\":0,\"value\":[0]}],\"inputs\":[{\"internalType\":\"string\",\"name\":\"_username\",\"type\":\"string\"},{\"internalType\":\"string\",\"name\":\"_password\",\"type\":\"string\"}],\"name\":\"loginUser\",\"outputs\":[],\"selector\":[583930597,653672489],\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"conflictFields\":[{\"kind\":0},{\"kind\":2,\"slot\":0,\"value\":[0]},{\"kind\":4,\"value\":[1]}],\"inputs\":[{\"internalType\":\"string\",\"name\":\"_username\",\"type\":\"string\"},{\"internalType\":\"string\",\"name\":\"_password\",\"type\":\"string\"}],\"name\":\"registerUser\",\"outputs\":[],\"selector\":[489573117,1792936861],\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"conflictFields\":[{\"kind\":3,\"slot\":1,\"value\":[0]},{\"kind\":4,\"value\":[1]}],\"inputs\":[{\"internalType\":\"uint256\",\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"userAddresses\",\"outputs\":[{\"internalType\":\"address\",\"name\":\"\",\"type\":\"address\"}],\"selector\":[1345100757,3782994093],\"stateMutability\":\"view\",\"type\":\"function\"},{\"conflictFields\":[{\"kind\":3,\"slot\":0,\"value\":[0]}],\"inputs\":[{\"internalType\":\"address\",\"name\":\"\",\"type\":\"address\"}],\"name\":\"users\",\"outputs\":[{\"internalType\":\"string\",\"name\":\"username\",\"type\":\"string\"},{\"internalType\":\"string\",\"name\":\"password\",\"type\":\"string\"}],\"selector\":[2826186938,1749762697],\"stateMutability\":\"view\",\"type\":\"function\"}]"};

    public static final String ABI = org.fisco.bcos.sdk.v3.utils.StringUtils.joinAll("", ABI_ARRAY);

    public static final String FUNC_GETUSERCOUNT = "getUserCount";

    public static final String FUNC_LOGINUSER = "loginUser";

    public static final String FUNC_REGISTERUSER = "registerUser";

    public static final String FUNC_USERADDRESSES = "userAddresses";

    public static final String FUNC_USERS = "users";

    public static final Event USERLOGGEDIN_EVENT = new Event("UserLoggedIn",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event USERREGISTERED_EVENT = new Event("UserRegistered",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    protected Register(String contractAddress, Client client, CryptoKeyPair credential) {
        super(getBinary(client.getCryptoSuite()), contractAddress, client, credential);
    }

    public static String getBinary(CryptoSuite cryptoSuite) {
        return (cryptoSuite.getCryptoTypeConfig() == CryptoType.ECDSA_TYPE ? BINARY : SM_BINARY);
    }

    public static String getABI() {
        return ABI;
    }

    public List<UserLoggedInEventResponse> getUserLoggedInEvents(
            TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(USERLOGGEDIN_EVENT, transactionReceipt);
        ArrayList<UserLoggedInEventResponse> responses = new ArrayList<UserLoggedInEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            UserLoggedInEventResponse typedResponse = new UserLoggedInEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.userAddress = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public List<UserRegisteredEventResponse> getUserRegisteredEvents(
            TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(USERREGISTERED_EVENT, transactionReceipt);
        ArrayList<UserRegisteredEventResponse> responses = new ArrayList<UserRegisteredEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            UserRegisteredEventResponse typedResponse = new UserRegisteredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.userAddress = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.username = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public BigInteger getUserCount() throws ContractException {
        final Function function = new Function(FUNC_GETUSERCOUNT,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallWithSingleValueReturn(function, BigInteger.class);
    }

    public TransactionReceipt loginUser(String _username, String _password) {
        final Function function = new Function(
                FUNC_LOGINUSER,
                Arrays.<Type>asList(new Utf8String(_username),
                new Utf8String(_password)),
                Collections.<TypeReference<?>>emptyList(), 0);
        return executeTransaction(function);
    }

    public String loginUser(String _username, String _password, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_LOGINUSER,
                Arrays.<Type>asList(new Utf8String(_username),
                        new Utf8String(_password)),
                Collections.<TypeReference<?>>emptyList(), 0);
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForLoginUser(String _username, String _password) {
        final Function function = new Function(
                FUNC_LOGINUSER,
                Arrays.<Type>asList(new Utf8String(_username),
                new Utf8String(_password)),
                Collections.<TypeReference<?>>emptyList(), 0);
        return createSignedTransaction(function);
    }



    public Tuple2<String, String> getLoginUserInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_LOGINUSER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = this.functionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(),
                (String) results.get(1).getValue()
                );
    }

    public TransactionReceipt registerUser(String _username, String _password) {
        final Function function = new Function(
                FUNC_REGISTERUSER,
                Arrays.<Type>asList(new Utf8String(_username),
                new Utf8String(_password)),
                Collections.<TypeReference<?>>emptyList(), 0);
        return executeTransaction(function);
    }

    public String getSignedTransactionForRegisterUser(String _username, String _password) {
        final Function function = new Function(
                FUNC_REGISTERUSER,
                Arrays.<Type>asList(new Utf8String(_username),
                new Utf8String(_password)),
                Collections.<TypeReference<?>>emptyList(), 0);
        return createSignedTransaction(function);
    }

    public String registerUser(String _username, String _password, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_REGISTERUSER,
                Arrays.<Type>asList(new Utf8String(_username),
                new Utf8String(_password)),
                Collections.<TypeReference<?>>emptyList(), 0);
        return asyncExecuteTransaction(function, callback);
    }

    public Tuple2<String, String> getRegisterUserInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_REGISTERUSER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = this.functionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(),
                (String) results.get(1).getValue()
                );
    }

    public String userAddresses(BigInteger param0) throws ContractException {
        final Function function = new Function(FUNC_USERADDRESSES,
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallWithSingleValueReturn(function, String.class);
    }

    public Tuple2<String, String> users(String param0) throws ContractException {
        final Function function = new Function(FUNC_USERS,
                Arrays.<Type>asList(new Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = executeCallWithMultipleValueReturn(function);
        return new Tuple2<String, String>(
                (String) results.get(0).getValue(),
                (String) results.get(1).getValue());
    }

    public static Register load(String contractAddress, Client client, CryptoKeyPair credential) {
        return new Register(contractAddress, client, credential);
    }

    public static Register deploy(Client client, CryptoKeyPair credential) throws
            ContractException {
        return deploy(Register.class, client, credential, getBinary(client.getCryptoSuite()), getABI(), null, null);
    }

    public static class UserLoggedInEventResponse {
        public TransactionReceipt.Logs log;

        public String userAddress;
    }

    public static class UserRegisteredEventResponse {
        public TransactionReceipt.Logs log;

        public String userAddress;

        public String username;
    }
}
