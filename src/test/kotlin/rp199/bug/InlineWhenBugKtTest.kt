package rp199.bug

import org.junit.jupiter.api.Test

internal class InlineWhenBugKtTest{

    @Test
    fun `inline func should be testable`(){
        inlineEnumWhen(SomeEnum.A)
    }
}