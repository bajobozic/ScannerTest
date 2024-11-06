package rs.bajobozic.scannertest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScannerScreen(modifier: Modifier= Modifier) {
    var productCode by remember { mutableStateOf("") }
    var enteredProductCode by remember { mutableStateOf("") }

    var barcode by remember { mutableStateOf("") }
    var enteredBarcode by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Product Code Text Field
        OutlinedTextField(
            value = productCode,
            onValueChange = { productCode = it },
            label = { Text("Product Code") },
            placeholder = { Text("Enter Product Code") },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.moveFocus(FocusDirection.Down)
                    enteredProductCode = productCode
                }
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // Reflect Product Code Text
        Text(
            text = if (enteredProductCode.isNotEmpty()) "Entered Product Code: $enteredProductCode" else "",
            style = MaterialTheme.typography.bodyMedium
        )

        // Barcode Text Field
        OutlinedTextField(
            value = barcode,
            onValueChange = { barcode = it },
            label = { Text("Barcode") },
            placeholder = { Text("Enter Barcode") },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                    enteredBarcode = barcode
                }
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // Reflect Barcode Text
        Text(
            text = if (enteredBarcode.isNotEmpty()) "Entered Barcode: $enteredBarcode" else "",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScannerScreenPreview() {
    ScannerScreen()
}