package com.example.se114_whatthefood_fe.view.authScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.se114_whatthefood_fe.ui.theme.BlurGray
import com.example.se114_whatthefood_fe.ui.theme.LightGreen
import com.example.se114_whatthefood_fe.ui.theme.White

@Composable
fun TabButton(text: String, isSelected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color.Transparent else White,
            contentColor = if (isSelected) White else LightGreen
        ),
        modifier = modifier
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}

@Composable
fun ButtonIcon(icon: ImageVector, onClick:()->Unit, colorBackGround: Color, colorIcon: Color, modifier: Modifier = Modifier) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = colorBackGround,
            contentColor = colorIcon)
    ) {
        androidx.compose.material3.Icon(
            imageVector = icon,
            contentDescription = null,
            tint = colorIcon
        )
    }
}

@Composable
fun ButtonWithIcon(
    text: String,
    onClick: () -> Unit,
    leadingIcon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = White,
            contentColor = LightGreen
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            ){
            leadingIcon()
            Spacer(modifier = Modifier.weight(1f))
            Text(text = text,
                 fontSize = 16.sp,
                 color = Color.Black,
                 modifier = modifier.padding(start = 8.dp))
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun RoundCornerTextFieldWithIcon( leadingIcon: @Composable () -> Unit,
                                    placeholder: String,
                                    value: String,
                                    onValueChange: (String) -> Unit,
                                    modifier: Modifier = Modifier,
                                    isPassword: Boolean = false,
                                  trailingIcon: @Composable (() -> Unit)? = null,
                                    isPasswordVisibility: Boolean? = false,
                                  keyBoardOption: KeyboardOptions? = null)
{
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder, color = BlurGray) },
        leadingIcon = leadingIcon,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.fillMaxWidth(),
        visualTransformation = if (isPassword)
        {
            if (isPasswordVisibility == true)
                VisualTransformation.None
            else
                PasswordVisualTransformation() // Hiển thị mật khẩu

        } else VisualTransformation.None,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent, // Màu khi TextField được focus
            unfocusedIndicatorColor = Color.Transparent, // Màu khi TextField không được focus
            disabledIndicatorColor = Color.Transparent
        ),
        trailingIcon = trailingIcon,
        keyboardOptions = keyBoardOption ?: KeyboardOptions.Default,
    )
}

@Composable
fun RoundCornerButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = White,
            contentColor = LightGreen,
            disabledContainerColor = BlurGray,
            disabledContentColor = Color.White
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = text,
            modifier = modifier,
            fontSize = 16.sp)

    }
}

@Composable
fun DividerWithCenterText(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp), // Thêm padding cho Row
        verticalAlignment = Alignment.CenterVertically, // Căn giữa theo chiều dọc
        horizontalArrangement = Arrangement.Center // Căn giữa theo chiều ngang
    ) {
        // Đường kẻ bên trái
        HorizontalDivider(
            modifier = modifier.weight(1f), // Chiếm hết không gian còn lại
            thickness = 1.dp, // Độ dày của đường kẻ
            color = BlurGray // Màu của đường kẻ (màu xám nhạt như trong hình)
        )

        // Text "HOẶC"
        Text(
            text = text,
            modifier = modifier.padding(horizontal = 8.dp), // Khoảng cách giữa text và đường kẻ
            fontSize = 16.sp,
            color = BlurGray // Màu của chữ (màu xám nhạt)
        )

        // Đường kẻ bên phải
        HorizontalDivider(
            modifier = modifier.weight(1f), // Chiếm hết không gian còn lại
            thickness = 1.dp,
            color = BlurGray // Màu của đường kẻ
        )
    }
}