import React from 'react';
import '@testing-library/jest-dom/extend-expect';
import { fireEvent, render, wait } from '@testing-library/react';
import i18n from 'i18n/__mocks__/i18nMock';
import { sessionMockEdit as sessionMock } from 'components/__mocks__/sessionMocks';
import SessionForm from 'components/SessionForm';
import { createMuiTheme } from '@material-ui/core';
import { ThemeProvider } from '@material-ui/styles';

const theme = createMuiTheme();

describe('Session Form', () => {
  it('shows form', () => {
    const { getByLabelText, getByTestId } = render(
      <ThemeProvider theme={theme}>
        <SessionForm session={sessionMock} />
      </ThemeProvider>
    );

    expect(getByTestId('session-id').value).toBe(sessionMock.id.toString());
    expect(getByLabelText('entities.session.name').value).toBe(sessionMock.name);
    expect(getByLabelText('entities.session.track').value).toBe(sessionMock.track);
  });

  it('submits form', async () => {
    const handleSubmit = jest.fn();
    const { getByTestId } = render(
      <ThemeProvider theme={theme}>
        <SessionForm session={sessionMock} onSubmit={handleSubmit} />
      </ThemeProvider>
    );

    const form = getByTestId('session-form');
    fireEvent.submit(form);

    await wait(() => {
      expect(handleSubmit).toHaveBeenCalledTimes(1);
    });
  });
});
