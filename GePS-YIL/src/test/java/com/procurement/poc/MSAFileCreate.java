package com.procurement.poc;

import com.procurement.poc.base.BaseTest;
import com.procurement.poc.interfaces.IMSA;
import org.testng.annotations.Test;

import java.io.IOException;

public class MSAFileCreate extends BaseTest {

    @Test
    public void modifyMSATest() throws IOException {
        iMSA.msamodify();
    }

}
